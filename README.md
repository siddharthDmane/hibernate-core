1. first create the simple maven project.
2. add dependencies for hibernate and oracle database in pom.xml. 
   2.1. org.hibernate.orm version { hibernate-core (7.0.0.Final) }
   2.2. com.oracle.database.jdbc { ojdbc11 (23.4.0.24.05) }
   2.3. after adding and saving dependncies, mostly we get compatibility error
        for 'org.jboss.logging' in hibernate.
    --  in this case, hibernate is requiring 3.6.0.Final version 'org.jboss.logging'
        so add it's explicit dependency inside <dependencyManagement><dependencies>
        </dependencies></dependencyManagement>.
    --  or just click on bulb icon on hibernate dependency warning it will show you version
        to add explicitly just click on that version it will automatically add it's dependency
        inside above mentioned tags.
3. After adding all dependencies, create resources folder under src/main.
4. Add hibernate.cfg.xml file in it, add all properties of databse in it.       

----------------------------------------------------------------------------------------------------

for inserting data into tables

1. While creating Entity classes don't use parameterized constructor if you are using @GeneratedValue, and 1:1, 1:M, M:N etc relationships or you can create the constructor excluding these variables.
2. you can create default constructor and use setters.

----------------------------------------------------------------------------------------------------

for retriving data from tables

!! avoid calling foreign objects within toString methods of both the dependent classes. it can causes infinite loop error.

1. HQL (Entity specific - Entity is Student then use Student in HQL)
   -- query language is different than native.
   -- for this option we need exact all instance attributes of class for mapping the retrived data from table.
   -- consider,
        select * from Student;
      we can map it's result to Student class if no recuursion in toString method.
   -- consider,
        select s.name, s.age from Student s;
      here, we can create DTO class containing name and age and can map it's result directly.

2. Native SQL (DB specific - table name in db is student use student)
   -- we can write queries as we write in mysql/ oracle.
   -- for this option we need exact all instance attributes of class for mapping the retrived data from table.
   -- consider,
        select * from student;
      we can map it's result to Student class if no recuursion in toString method.
   -- consider,
        select s.name, s.age from Student s;
      we can create DTO class contianing name, age but can not map query result directly.
      we have to take result as List<Objet[]> and the have to set DTO object using either setters or constructor.

----------------------------------------------------------------------------------------------------        