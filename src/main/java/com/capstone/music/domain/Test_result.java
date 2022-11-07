package com.capstone.music.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test_result {
    @Id
    @GeneratedValue
    private Long id;
    private String result1;
    private String result2;
    private String result3;
    private String result4;
    private String result5;
}
