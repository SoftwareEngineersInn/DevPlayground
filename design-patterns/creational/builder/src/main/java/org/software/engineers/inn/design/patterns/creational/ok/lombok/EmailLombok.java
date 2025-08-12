package org.software.engineers.inn.design.patterns.creational.ok.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Lombok offers the @Builder annotation
 * Allows you to apply the builder pattern without writing a lot of code
 * like the traditional way
 * **/
@Getter
@ToString
@AllArgsConstructor
@Builder
public class EmailLombok {
    private final String to;
    private final String subject;
    private final String body;
    private final boolean isHtml;
}
