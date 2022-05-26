package com.demo.jobsearchproject.dto;
import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
        private Long id;
        private String jobTitle;
        private String location;

}
