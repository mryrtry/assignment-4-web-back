package org.mryrt.web.PointCheck.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "assignment_web_4_results")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private long createdById;

    @Column(nullable = false)
    private float x;

    @Column(nullable = false)
    private float y;

    @Column(nullable = false)
    private float r;

    @Column(nullable = false)
    private boolean inArea;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private long processingTime;

}
