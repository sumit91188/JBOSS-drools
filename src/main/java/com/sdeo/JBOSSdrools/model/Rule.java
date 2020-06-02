package com.sdeo.JBOSSdrools.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Sumit Deo
 */

@Getter
@Setter
@ToString
@Entity
@Table
public class Rule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String ruleKey;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false, unique = true)
    private String version;
    @Column(nullable = true, unique = true)
    private String lastModifyTime;
    @Column(nullable = false)
    private String createTime;
}
