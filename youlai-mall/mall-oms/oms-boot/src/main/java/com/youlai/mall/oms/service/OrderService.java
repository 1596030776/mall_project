package com.youlai.mall.oms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import com.github.binarywang.wxpay.bean.notify.SignatureHeader;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.youlai.mall.oms.pojo.entity.OmsOrder;
import com.youlai.mall.oms.pojo.query.OrderPageQuery;
import com.youlai.mall.oms.pojo.vo.OrderConfirmVO;
import com.youlai.mall.oms.pojo.vo.OrderSubmitResultVO;
import com.youlai.mall.oms.pojo.form.OrderSubmitForm;

/**
 * 订单业务接口
 *
 * @author huawei
 * @email huawei_code@163.com
 * @date 2020-12-30 22:31:10
 */
public interface OrderService extends IService<OmsOrder> {

    /**
     * 订单确认 → 进入创建订单页面
     * <p>
     * 获取购买商品明细、用户默认收货地址、防重提交唯一token
     * 进入订单创建页面有两个入口，1：立即购买；2：购物车结算
     *
     * @param skuId 直接购买必填，购物车结算不填
     * @return
     */
    OrderConfirmVO confirmOrder(Long skuId);

    /**
     * 订单提交
     */
    OrderSubmitResultVO submitOrder(OrderSubmitForm orderSubmitForm);

    /**
     * 订单支付
     */
   boolean payOrder(Long orderId);

    /**
     * 系统关闭订单
     */
    boolean closeOrder(String orderSn);

    /**
     * 删除订单
     */
    boolean deleteOrder(Long id);

    /**
     * 处理微信支付成功回调
     *
     * @param signatureHeader 签名头
     * @param notifyData      加密通知
     * @throws WxPayException 微信异常
     */
    void handleWxPayOrderNotify(SignatureHeader signatureHeader, String notifyData) throws WxPayException;

    /**
     * 处理微信退款成功回调
     *
     * @param signatureHeader 签名头
     * @param notifyData      加密通知
     * @throws WxPayException 微信异常
     */
    void handleWxPayRefundNotify(SignatureHeader signatureHeader, String notifyData) throws WxPayException;

    /**
     * 订单分页列表
     *
     * @param queryParams
     * @return
     */
    IPage<OmsOrder> listOrderPages(OrderPageQuery queryParams);

}

