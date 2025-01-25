package com.Contact_Manager.contact_manager.Helpers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    private String content;
    @Builder.Default
    private messageEnum type = messageEnum.blue;
}

