package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	ArrayList<Note> notes;
	float NUM = 5;

	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	public void settings() {
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48)
		println(i);

	}

	public void setup() {
		notes = new ArrayList<Note>();
		loadNotes();
		printScores();
	}

	void loadNotes() {
		for (int i = 0; i < score.length(); i++) {
			char currentNote = score.charAt(i);
			int currentDuration = 1;

			if (i + 1 != score.length()) {
				char nextChar = score.charAt(i + 1);
				if (Character.isDigit(nextChar)) {
					currentDuration = nextChar - '0';
					i++;
				}
			}

			Note note = new Note(currentNote, currentDuration);
			notes.add(note);
		}
	}

	void printScores() {
		for (Note note : notes) {
			println(note.getNote() + "\t" + note.getDuration() + "\t" + (note.getDuration() == 1 ? "Quaver" : "Crotchet"));
		}
	}

	public void draw() {
		float NUM = 0.05f * width;
		background(255, 255, 255);

		//drawing lines
		for (int i = 0; i < 5; i++) {
			float y = map(i, -4, 6, NUM, height - NUM);
			strokeWeight(2.5f);
			stroke(0,0,0);
			line(NUM, y, width - NUM, y);

		}



		//drawing notes
		int line_x = 75; // co-ordinates
		int	line_y = 383;
		int line_y2 = 290;

		int ellipse_x = 68;
		int ellipse_y = 380;

		PFont f;
		f = createFont("Arial",16,true);
		textFont(f,36);


		for (int i = 0; i < score.length(); i++) {


		}

		line_x = 75;
		line_y = 383;
		int line_x3 = 75;
		int line_x2 = 50;
		int line_y3 = 315;
		int line_y4 = 340;

		for (int i = 0; i < score.length(); i++) {

			if(mouseX > line_x - 50 && mouseX < line_x + 50) {
				fill(255,0,0);
				stroke(255,0,0);
			}
			else{
				fill(0,0,0);
				stroke(0,0,0);
			}
			if(score.charAt(i) == '2'){

				line(line_x2, line_y3, line_x3, line_y4);
			}
			else{
				text(score.charAt(i),line_x,100);
				line(line_x, line_y, line_x, line_y2);

				ellipse(ellipse_x, ellipse_y, 25, 25);
				line_x += 100; // increments
				ellipse_x += 100;

				line_y -= 24;
				line_y2 -= 24;
				ellipse_y -= 24;
				line_y3 -= 24;
				line_x2 += 24;
				line_x3 +=24;
				line_y4 -=24;
			}


		}

	}
}