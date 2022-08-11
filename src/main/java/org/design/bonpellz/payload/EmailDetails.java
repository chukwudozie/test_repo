package org.design.bonpellz.payload;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipient;
    private String messageBody;
    private String subject;
    private  String attachment;
}
