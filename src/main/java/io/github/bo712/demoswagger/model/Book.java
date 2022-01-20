package io.github.bo712.demoswagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * @author K.Babakov
 * @since 20 янв. 2022 г.
 */
@Data
@AllArgsConstructor
@Schema(description = "Сущность книги")
public class Book {

    @Schema(description = "id книги")
    private Integer id;

    @Schema(description = "Название книги")
    @NonNull
    private String title;

    @Schema(description = "Имя автора книги")
    @NonNull
    private String author;

    @Schema(description = "Год первого тиража")
    @NonNull
    private Integer yearOfRelease;

    @Schema(description = "ISBN (книжный штрих код) – это код международной системы стандартной нумерации книг и брошюр International Standard Book Number. "
            + "Это уникальный идентификационный номер издания.")
    @NonNull
    private String isbn;
}
