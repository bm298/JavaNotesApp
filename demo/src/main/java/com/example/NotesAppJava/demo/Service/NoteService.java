package com.example.NotesAppJava.demo.Service;

import com.example.NotesAppJava.demo.Model.NoteData;

import java.util.List;

public interface NoteService {

   NoteData addNote(NoteData note);
   List<NoteData> getAllNotes();
   NoteData markNoteAsComplete(long id);
   NoteData updateNoteDescription(long id, NoteData note);
   void deleteNote(long id);

}
