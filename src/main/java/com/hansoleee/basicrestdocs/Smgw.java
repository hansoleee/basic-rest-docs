package com.hansoleee.basicrestdocs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Smgw {

    private Integer id;
    private Integer value;

    public Smgw(Integer id, Integer value) {
        this.id = id;
        this.value = value;
    }
}
