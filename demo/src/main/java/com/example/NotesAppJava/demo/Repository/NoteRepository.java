package com.example.NotesAppJava.demo.Repository;

import com.example.NotesAppJava.demo.Model.NoteData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository <NoteData,Long>{



}
