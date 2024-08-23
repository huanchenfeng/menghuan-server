package com.meng.entity.bill;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("bill_type")
@ApiModel(value = "BillType对象", description = "")
public class BillType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String typeName;

    private Boolean isIncome;
}
