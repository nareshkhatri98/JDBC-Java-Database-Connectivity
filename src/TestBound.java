import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class Project {
    private String projectName; // simple properties.
    private PropertyChangeSupport support; // bound properties

    public Project(String projectName) {
        this.projectName = projectName;
        this.support = new PropertyChangeSupport(this); // Generating an event.
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        String oldProjectName = this.projectName;
        this.projectName = projectName;
        support.firePropertyChange("projectName", oldProjectName, projectName);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}

public class TestBound {
    public static void main(String[] args) {
        Project obj = new Project("project E-commerce");
        obj.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                System.out.println("Project name changed from " + e.getOldValue() + " to " + e.getNewValue());
            }
        });
        obj.setProjectName("project Gold Prediction");
    }
}
