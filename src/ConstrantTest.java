import java.beans.PropertyChangeEvent;
import  java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

class Employee{
    private  String name;
    private Project project;
    protected VetoableChangeSupport vetoableSupport;

    public Employee(String name){
        this.name = name;
        this.vetoableSupport = new VetoableChangeSupport(this);
    }

    public  String getName()
    {
        return  name;
    }
    public Project getProject()
    {
        return  project;
    }
    public  void  setProject(Project project ) throws  PropertyVetoException{
        Project oldProject = this.project;
        vetoableSupport.fireVetoableChange("project", oldProject,project);
        this.project = project;
    }
    public  void addVetoableChangeListener(VetoableChangeListener listener)
    {
        vetoableSupport.addVetoableChangeListener(listener);
    }
    public void removeVetoableChangeListener(VetoableChangeListener listener )

    {
        vetoableSupport.removeVetoableChangeListener(listener);

    }
}

public class ConstrantTest {
    public static void main(String[] args) {
        Project project1 = new Project("Project A");
        Project project2 = new Project("Project B");

        Employee employee = new Employee("Anish");
        employee.addVetoableChangeListener(new VetoableChangeListener() {
            @Override
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Project newProject =(Project)  evt.getNewValue();
                if(newProject != null && employee.getProject() != null)
                {
                    throw  new PropertyVetoException("employee can only be assigned  to one at a time",evt);
                }
            }
        });
        try{
            employee.setProject(project1);
            System.out.println(employee.getName() + "is assigned to " + employee.getProject());
            employee.setProject(project2);
        }catch (PropertyVetoException e){
            System.out.println("vetoed:" +e.getMessage());
        }
    }
}
