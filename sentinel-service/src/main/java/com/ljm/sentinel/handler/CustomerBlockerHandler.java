package com.ljm.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ljm.sentinel.dto.CommonResult;

public class CustomerBlockerHandler {

    public static CommonResult handlerException(BlockException e){

        return CommonResult.fail(444, "this is customerBlockerHandler");

    }

}
