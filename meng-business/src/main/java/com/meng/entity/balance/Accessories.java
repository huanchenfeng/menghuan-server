package com.meng.entity.balance;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("buff_id")
    private Integer buffId;

    @ApiModelProperty("BUFF在售价")
    @JsonProperty("buff_sell_price")
    private BigDecimal buffSellPrice;

    @ApiModelProperty("BUFF在售数量")
    @JsonProperty("buff_sell_num")
    private Integer buffSellNum;

    @ApiModelProperty("BUFF求购价")
    @JsonProperty("buff_buy_price")
    private BigDecimal buffBuyPrice;

    @ApiModelProperty("BUFF求购数量")
    @JsonProperty("buff_buy_num")
    private Integer buffBuyNum;

    @ApiModelProperty("Steam在售价")
    @JsonProperty("steam_sell_price")
    private BigDecimal steamSellPrice;

    @ApiModelProperty("Steam在售数量")
    @JsonProperty("steam_sell_num")
    private Integer steamSellNum;

    @ApiModelProperty("Steam求购价")
    @JsonProperty("steam_buy_price")
    private BigDecimal steamBuyPrice;

    @ApiModelProperty("Steam求购数量")
    @JsonProperty("steam_buy_num")
    private Integer steamBuyNum;

    @ApiModelProperty("Steam市场名称")
    @JsonProperty("market_hash_name")
    private String marketHashName;

    @ApiModelProperty("饰品中文名称")
    private String name;

    @ApiModelProperty("饰品图片")
    private String img;

    @ApiModelProperty("YYYP平台饰品ID")
    @JsonProperty("yyyp_id")
    private Integer yyypId;

    @ApiModelProperty("YYYP在售价")
    @JsonProperty("yyyp_sell_price")
    private BigDecimal yyypSellPrice;

    @ApiModelProperty("YYYP在售数量")
    @JsonProperty("yyyp_sell_num")
    private Integer yyypSellNum;

    @ApiModelProperty("YYYP求购价")
    @JsonProperty("yyyp_buy_price")
    private BigDecimal yyypBuyPrice;

    @ApiModelProperty("YYYP求购数量")
    @JsonProperty("yyyp_buy_num")
    private Integer yyypBuyNum;

    @ApiModelProperty("平台价格最大值")
    @JsonProperty("max_price")
    private BigDecimal maxPrice;

    @ApiModelProperty("Steam当日成交量")
    @JsonProperty("turnover_number")
    private BigDecimal turnoverNumber;

    @ApiModelProperty("Steamid")
    @JsonProperty("steam_id")
    private Integer steamId;
}
