package com.example.NotesAppJava.demo.Service;

import com.example.NotesAppJava.demo.Model.NoteData;
import com.example.NotesAppJava.demo.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<NoteData> getAllNotes() {

        List<NoteData> notes= new ArrayList<>();
        notes.addAll(noteRepository.findAll());

        if (!notes.isEmpty()){
            System.out.println(notes);
            return notes;
        }

        return null;
    }

    @Override
    public NoteData addNote(NoteData note) {
        return noteRepository.save(note);
    }

    @Override
    public NoteData markNoteAsComplete(long id) {
        NoteData noteToMarkAsComplete= noteRepository.findById(id).orElse(null);

        if (noteToMarkAsComplete!=null){
            noteToMarkAsComplete.setIsTaskComplete(true);
            noteRepository.save(noteToMarkAsComplete);
        }

        return null;

    }

    @Override
    public NoteData updateNoteDescription(long id, NoteData note) {
        NoteData updateDescr= noteRepository.findById(id).orElse(null);

        if (updateDescr!=null){
            updateDescr.setTaskDescription(note.getTaskDescription());
            noteRepository.save(updateDescr);
        }
        return null;
    }

    @Override
    public void deleteNote(long id) {
        if (noteRepository.existsById(id)){
            noteRepository.deleteById(id);
        }
    }
}
