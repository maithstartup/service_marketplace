package com.au.service_project.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Getter
@Setter
public class ServiceCountResponse {

    private List<String > serviceNames;
    private List<Integer> transactionCounts;
}
