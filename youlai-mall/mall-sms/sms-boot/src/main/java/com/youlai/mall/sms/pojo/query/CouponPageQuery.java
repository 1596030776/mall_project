package com.youlai.mall.sms.pojo.query;

import com.youlai.common.base.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xinyi
 * @desc: 优惠券分页查询对象
 * @date 2021/7/11
 */
@ApiModel("优惠券分页查询对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponPageQuery extends BasePageQuery {

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("优惠券码")
    private String code;
}
