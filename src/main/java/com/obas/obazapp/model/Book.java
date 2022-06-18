package com.obas.obazapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table (name = "BOOK")
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false, updatable = false)
    private Long id;
    @NonNull
    private String booktitle;
    @NonNull
    private String author;
    @NonNull
    private String rating;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "users")
    private Users users;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", booktitle='" + booktitle + '\'' +
                ", author='" + author + '\'' +
                ", rating='" + rating + '\'' +
                ", users=" + users +
                '}';
    }
}
