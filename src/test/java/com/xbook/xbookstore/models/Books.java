package com.xbook.xbookstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Books {

    @JsonProperty("books")
    private List<Book> books;
}
