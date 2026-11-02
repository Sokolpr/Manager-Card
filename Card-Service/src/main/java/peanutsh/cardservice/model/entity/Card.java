package peanutsh.cardservice.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import peanutsh.cardservice.dictionary.CardStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "cards",
        indexes ={
                @Index(name = "idx_card_pan",columnList = "pan"),
                @Index(name = "idx_card_id",columnList = "id")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_pan_card",columnNames = "pan")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "pan",nullable = false)
    private String pan;

    @Column(name = "pin",nullable = false)
    private String pin;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "fk_card_user"))
    private User userId;

    @Column(name = "balance",updatable = true, nullable = false)
    private BigDecimal balance;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status",updatable = true, nullable = false)
    private CardStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "blocked_at")
    private Instant blockedAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "expiration_month",nullable = false,updatable = false)
    private Integer expMonth;

    @Column(name = "expiration_year",nullable = false,updatable = false)
    private Integer expYear;


}
