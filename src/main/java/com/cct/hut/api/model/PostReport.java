package com.cct.hut.api.model;

import com.cct.hut.api.enums.ReportType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PostReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReportType reportType;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    private Post post;


    public PostReport(Long id, ReportType reportType) {
        this.id = id;
        this.reportType = reportType;
    }

    public PostReport() {
    }
}
