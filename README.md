# small-java-projects

# **ATM Demo**

# **Prerequisites:**

Install and configure following libraries

_Java 8_

_Apache Maven 3.8.2_

_Git 2.30.1_

_Basic understanding of running java, maven and git commands is required_

# **Setting the environment**

_set JAVA_HOME environment variable by setting the appropriate java installation path_

For example on linux/mac the command to set JAVA_HOME might look like this

`export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_301.jdk/Contents/Home`

_make sure PATH variable is pointing to appropriate java, maven, git executables_

# **Getting the source code**

`git clone https://github.com/darshanvartak7/small-java-projects.git`

# Change directory to banking directory in the source code

`cd {checkout location}/small-java-projects/banking`

# **Compiling the source code**

From the **banking** directory in the source code run following command

`mvn clean compile`

# **Running Tests**

From the **banking** directory in the source code run following command

`mvn clean test`

# **Running the application**

From the **banking** directory in the source code run following commands

set **CLASSPATH** variable as give below

CLASSPATH=./target/classes

For example in linux/mac run following command

`export CLASSPATH=./target/classes`

run following command to execute the application

`java -classpath $CLASSPATH com.abcbank.banking.ui.AutomaticTellerMachine`
