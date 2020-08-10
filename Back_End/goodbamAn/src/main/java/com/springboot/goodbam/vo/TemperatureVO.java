package com.springboot.goodbam.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TemperatureVO extends UserVO {

    private String raspID;
    private String temperature;
    private String humidity;
    private String time;
    private String date;
}
