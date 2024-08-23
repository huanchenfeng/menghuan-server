package com.meng.entity.bill;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-23 15:27:27
 */
@Getter
@Setter
@ApiModel(value = "Bill对象", description = "")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer typeId;

    private BigDecimal amount;

    private LocalDate date;

    private String note;
}
