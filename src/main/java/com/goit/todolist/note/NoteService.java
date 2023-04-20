package com.goit.todolist.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

}