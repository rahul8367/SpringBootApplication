package com.demo.jobsearchproject.dto;
import com.demo.jobsearchproject.entity.Commute;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
        private Long id;
        private String companyName;
        private String jobTitle;
        private String location;
        private List<String> commutes=new ArrayList<>();

}
