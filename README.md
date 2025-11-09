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
