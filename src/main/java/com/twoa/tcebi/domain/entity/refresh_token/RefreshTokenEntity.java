package com.twoa.tcebi.domain.entity.refresh_token;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refresh_token")
public class RefreshTokenEntity implements Persistable<String> {
    @Id
    @Column("id")
    private String id;
    @Column("token")
    private String refreshToken;
    @Transient
    private boolean isNew;
}
