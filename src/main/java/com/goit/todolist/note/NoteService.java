package com.goit.todolist.note;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = random.nextLong();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
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

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note not found for id " + id);
        }
        return notes.get(id);
    }

}
