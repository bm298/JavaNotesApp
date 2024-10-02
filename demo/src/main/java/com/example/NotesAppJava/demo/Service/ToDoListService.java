package com.example.NotesAppJava.demo.Service;

import com.example.NotesAppJava.demo.Model.NoteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ToDoListService {

    @Autowired
    private NoteService noteService;

    public void inputParser(){

        Scanner scanner= new Scanner(System.in);
        boolean exitMenu=false;

            while(!exitMenu){

            //Menu Item List
            System.out.println("\nTo-Do List:");
            System.out.println("\nChoose a Menu item:");
            System.out.println("1. Add a new note");
            System.out.println("2. Mark a note as complete");
            System.out.println("3. Delete a note");
            System.out.println("4. View all notes/tasks");
            System.out.println("5. Exit Menu & Terminate Note App");
            System.out.print("Choose an option: ");

            //User enters menu item number
            int menuItem= scanner.nextInt();

            if (menuItem==1){
                scanner.nextLine(); // Clear the buffer
                System.out.println("Enter note description");
                String noteDesc = scanner.nextLine();
                System.out.println("Enter note date");
                String noteDate = scanner.nextLine();
                System.out.println("before1");
                NoteData taskNote = new NoteData(noteDesc, noteDate);
                System.out.println("before2");
                noteService.addNote(taskNote);
                System.out.println("after");
                System.out.println("Note added");
            }

            else if (menuItem==2){
                System.out.println("Enter which note you want to mark as complete");
                int noteNumber= scanner.nextInt();
                noteService.markNoteAsComplete(noteNumber);
                System.out.println("Note " + noteNumber + " marked as completed ");
            }

            else if (menuItem==3){
                System.out.println("Enter which note you want to delete");
                int noteNumber= scanner.nextInt();
                System.out.println("Confirm with Y/N if you are sure you want to delete note number "+noteNumber +"?");
                String confirmNoteNumber= scanner.next();
                    if (confirmNoteNumber.equalsIgnoreCase("y")){
                        System.out.println("note about to get deleted...");
                        noteService.deleteNote(noteNumber);
                        System.out.println("Note " + noteNumber + " deleted ");
                    } else if (confirmNoteNumber.equalsIgnoreCase("n")) {
                        System.out.println("Delete cancelled, back to main menu");
                    }
                    else {
                        System.out.println("not an option try again...back at main menu");
                    }


            }

            else if (menuItem==4){
                System.out.println("Here are all your current notes");
                noteService.getAllNotes();
            }

            else if (menuItem==5) {
                exitMenu=true;
            }

            else {
                System.out.println("Invalid Input.");
                System.out.println("Press any button to try again.");
                scanner.next();
            }

        }

    }


}
