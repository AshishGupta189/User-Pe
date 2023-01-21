package com.vcriate.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Id
	private Integer userId;
	private String sessionId;
	private LocalDateTime sessionTime;
	private String mobile;
}
