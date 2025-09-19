package com.example.EcommerceSpring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
	private double rate;
	private int count;
}