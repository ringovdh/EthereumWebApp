package be.yorian.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "assessments")
public class Assessment {
	
	public static final int ASSESSMENT_UNSUBMITTED = 0;
    public static final int ASSESSMENT_SUBMITTED = 1;
    public static final int ASSESSMENT_COMPLETE = 2;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private int studentId;
	
	private int groupId;

	private int authorId;
	
	private int score1;
	
	private int score2;
	
	private int score3;
	
	private int score4;
	
	private int score5;
	
	private int score6;
	
	private int status;
	
	@Transient
	private List<Integer> scores;

	public Assessment(){
		this.scores = prepareScores();
	}
	
	public Assessment(int studentId, int groupId, int authorId) {
		this.studentId = studentId;
		this.groupId = groupId;
		this.authorId = authorId;
		this.status = ASSESSMENT_UNSUBMITTED;
		this.scores = prepareScores();
	}

private List<Integer> prepareScores() {
		
		scores = new ArrayList<Integer>();
		
		scores.add(0);
		scores.add(1);
		scores.add(2);
		scores.add(3);
		scores.add(4);
		scores.add(5);
		scores.add(6);
		scores.add(7);
		scores.add(8);
		scores.add(9);
		scores.add(10);
		
		return scores;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int student) {
		this.studentId = student;
	}


	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}



	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}



	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}



	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}



	public int getScore3() {
		return score3;
	}
	public void setScore3(int score3) {
		this.score3 = score3;
	}



	public int getScore4() {
		return score4;
	}
	public void setScore4(int score4) {
		this.score4 = score4;
	}



	public int getScore5() {
		return score5;
	}
	public void setScore5(int score5) {
		this.score5 = score5;
	}



	public int getScore6() {
		return score6;
	}
	public void setScore6(int score6) {
		this.score6 = score6;
	}



	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}



	public List<Integer> getScores() {
		return scores;
	}

}
