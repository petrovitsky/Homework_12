package com.goit.todolist.note;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 25; i++) {
            Note note = new Note();
            note.setTitle("note " + i);
            note.setContent("Some content" + i);
            add(note);
        }
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        Long id = (Long) random.nextLong();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(Long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note not found for id " + id);
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new RuntimeException("Note not found for id " + note.getId());
        }
        notes.put(note.getId(), note);
    }

    public Note getById(Long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note not found for id " + id);
        }
        return notes.get(id);
    }

}
