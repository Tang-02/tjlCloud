package com.tjl.cloud.entities.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 27701
 */
@Data
public class PayDTO implements Serializable {

    private Integer id;
    private String payNo;
    private String orderNo;
    private Integer userId;
    private BigDecimal amount;
}
