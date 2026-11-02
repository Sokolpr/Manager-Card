package peanutsh.cardservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import peanutsh.cardservice.dictionary.UserStatus;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_auth_user_id", columnList = "auth_user_id"),
                @Index(name = "idx_user_status", columnList = "user_status")

        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_forum_user_auth_id", columnNames = "auth_user_id"),
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "auth_user_id", nullable = false, updatable = false)
    private UUID authUserId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private UserStatus Status;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

//    @Column(name = "banned_until")
//    private Instant bannedUntil;
//
//    @Column(name = "ban_reason", columnDefinition = "TEXT")
//    private String banReason;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

//    @UpdateTimestamp
//    @Column(name = "updated_at", nullable = false)
//    private Instant updatedAt;

}
