package com.youlai.mall.ums.controller.admin;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.common.constant.GlobalConstants;
import com.youlai.common.result.PageResult;
import com.youlai.common.result.Result;
import com.youlai.mall.ums.dto.MemberInfoDTO;
import com.youlai.mall.ums.pojo.entity.UmsMember;
import com.youlai.mall.ums.service.IUmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@Api(tags = "「管理端」会员管理")
@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class UmsMemberController {

    private final IUmsMemberService memberService;

    @ApiOperation(value = "会员分页列表")
    @GetMapping
    public PageResult<UmsMember> listPageMembers(
            @ApiParam("页码") Long pageNum,
            @ApiParam("每页数量") Long pageSize,
            @ApiParam("会员昵称") String nickName
    ) {
        IPage<UmsMember> result = memberService.list(new Page<>(pageNum, pageSize), nickName);
        return PageResult.success(result);
    }

    @ApiOperation(value = "修改会员")
    @PutMapping(value = "/{memberId}")
    public <T> Result<T> update(
            @ApiParam("会员ID") @PathVariable Long memberId,
            @RequestBody UmsMember member
    ) {
        boolean status = memberService.updateById(member);
        return Result.judge(status);
    }

    @ApiOperation(value = "修改会员状态")
    @PatchMapping("/{memberId}/status")
    public <T> Result<T> updateMemberStatus(
            @ApiParam("会员ID") @PathVariable Long memberId,
            @RequestBody UmsMember member
    ) {
        boolean status = memberService.update(
                new LambdaUpdateWrapper<UmsMember>()
                        .eq(UmsMember::getId, memberId)
                        .set(UmsMember::getStatus, member.getStatus())
        );
        return Result.judge(status);
    }

    @ApiOperation(value = "删除会员")
    @DeleteMapping("/{ids}")
    public <T> Result<T> delete(
            @ApiParam("会员ID，多个以英文逗号(,)拼接") @PathVariable String ids
    ) {
        boolean status = memberService.update(new LambdaUpdateWrapper<UmsMember>()
                .in(UmsMember::getId, Arrays.asList(ids.split(",")))
                .set(UmsMember::getDeleted, GlobalConstants.STATUS_YES));
        return Result.judge(status);
    }

    @ApiOperation(value = "「实验室」获取会员信息")
    @GetMapping("/{memberId}/info")
    public Result<MemberInfoDTO> getMemberInfo(
            @ApiParam("会员ID") @PathVariable Long memberId
    ) {
        MemberInfoDTO memberInfoDTO = memberService.getMemberInfo(memberId);
        return Result.success(memberInfoDTO);
    }

    @ApiOperation(value = "「实验室」扣减会员余额")
    @PutMapping("/{memberId}/balances/_deduct")
    public Result deductBalance(@PathVariable Long memberId, @RequestParam Long amount) {
        boolean result = memberService.update(new LambdaUpdateWrapper<UmsMember>()
                .setSql("balance = balance - " + amount)
                .eq(UmsMember::getId, memberId));
        return Result.judge(result);
    }


}
