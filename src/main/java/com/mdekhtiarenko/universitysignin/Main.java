package com.mdekhtiarenko.universitysignin;

import com.mdekhtiarenko.universitysignin.dao.DisciplineDAOImpl;
import com.mdekhtiarenko.universitysignin.dao.Discipline_has_UserDAOImpl;
import com.mdekhtiarenko.universitysignin.dao.RoleDAOImpl;
import com.mdekhtiarenko.universitysignin.dao.UserDAOImpl;
import com.mdekhtiarenko.universitysignin.entity.Discipline;
import com.mdekhtiarenko.universitysignin.entity.User;
import com.mdekhtiarenko.universitysignin.spring.delegate.IndexDelegate;
import com.mdekhtiarenko.universitysignin.xml.XMLParser;

import java.util.ArrayList;

public class Main {
	  public static void main(String[] args) throws Exception {
//          UserDAOImpl userDAOImpl = new UserDAOImpl();
//		  userDAOImpl.create(new User( "Олександр", "Франків", 0, 1));
//		  userDAOImpl.create(new User( "Анна", "Полякова", 0, 1));
//		  userDAOImpl.create(new User( "Ілля", "Сірош", 0, 1));
//		  userDAOImpl.create(new User( "Дмитро", "Проскурня", 0, 1));
	      //		  PeriodDAOImpl period = new PeriodDAOImpl();
//		  period.nextPeriod();
//		  System.out.println( period.getPeriod().toString());
//		  period.setToDefault();
//		  System.out.println( period.getPeriod().toString());
//		  DisciplineDAOImpl disciplineDAO = new DisciplineDAOImpl();
//		  discipline.create(new Discipline(4, "OШІ", "Глибовець", true, 3.5, "None"));
//		  Discipline d = discipline.getDiscipline(2);
//		  d.setCredits(6);
//		  discipline.updateDiscipline(d);


//		  userDAOImpl.updateUser(dima);
//		  ArrayList<User> Users = userDAOImpl.getAllUsers();
//		  for(int i=0; i<Users.size(); i++){
//		  	System.out.println(Users.get(i).toString());
//		  }
		  //System.out.print(discipline.getDiscipline(2).toString());
//          Discipline_has_UserDAOImpl dudi = new Discipline_has_UserDAOImpl();
//          dudi.signIn(1, 4);
//
//          UserDAOImpl udi = new UserDAOImpl();
//          User iana = udi.getUser(1);
//          System.out.println(iana.toString());
//
//          DisciplineDAOImpl disciplineDAO = new DisciplineDAOImpl();
//          Discipline d1 = disciplineDAO.getDiscipline(4);
//          disciplineDAO.setDisciplineStudents(d1);
//          System.out.println(d1.toString());
//          RoleDAOImpl RDI = new RoleDAOImpl();
//          System.out.println(RDI.getRole(1));
//          DisciplineDAOImpl DDI = new DisciplineDAOImpl();
//          System.out.print(DDI.getAllDiscipline().toString());
//		  XMLParser xmlParser = new XMLParser();
//		  xmlParser.createInfoFile(2, "Глибовець", "None");
//		  System.out.println("Teacher: "+xmlParser.getTeacher(1)+" Description: "+xmlParser.getDescription(1));
//		  System.out.println("Teacher: "+xmlParser.getTeacher(2)+" Description: "+xmlParser.getDescription(2));
		  Discipline_has_UserDAOImpl ddi = new Discipline_has_UserDAOImpl();
		  ddi.signIn(1, 1);

	    }

}
