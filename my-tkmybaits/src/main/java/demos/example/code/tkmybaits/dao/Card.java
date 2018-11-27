package demos.example.code.tkmybaits.dao;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("card")
@Data
public class Card implements Serializable {

    private Integer id;
    private String card;

}

