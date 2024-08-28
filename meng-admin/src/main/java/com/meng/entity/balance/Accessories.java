package com.meng.entity.balance;

import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 饰品信息表
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-28 17:01:16
 */
@Getter
@Setter
@ApiModel(value = "Accessories对象", description = "饰品信息表")
public class Accessories implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("饰品ID")
    private Integer id;

    @ApiModelProperty("BUFF平台饰品ID")
    private Integer buffId;

    @ApiModelProperty("BUFF在售价")
    private BigDecimal buffSellPrice;

    @ApiModelProperty("BUFF在售数量")
    private Integer buffSellNum;

    @ApiModelProperty("BUFF求购价")
    private BigDecimal buffBuyPrice;

    @ApiModelProperty("BUFF求购数量")
    private Integer buffBuyNum;

    @ApiModelProperty("Steam在售价")
    private BigDecimal steamSellPrice;

    @ApiModelProperty("Steam在售数量")
    private Integer steamSellNum;

    @ApiModelProperty("Steam求购价")
    private BigDecimal steamBuyPrice;

    @ApiModelProperty("Steam求购数量")
    private Integer steamBuyNum;

    @ApiModelProperty("Steam市场名称")
    private String marketHashName;

    @ApiModelProperty("饰品中文名称")
    private String name;

    @ApiModelProperty("饰品图片")
    private String img;

    @ApiModelProperty("YYYP平台饰品ID")
    private Integer yyypId;

    @ApiModelProperty("YYYP在售价")
    private BigDecimal yyypSellPrice;

    @ApiModelProperty("YYYP在售数量")
    private Integer yyypSellNum;

    @ApiModelProperty("YYYP求购价")
    private BigDecimal yyypBuyPrice;

    @ApiModelProperty("YYYP求购数量")
    private Integer yyypBuyNum;

    @ApiModelProperty("平台价格最大值")
    private BigDecimal maxPrice;

    @ApiModelProperty("Steam当日成交量")
    private BigDecimal turnoverNumber;
}
