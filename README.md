# Refactoring dev tool
Code written in Java. Takes any input files as arguments and uses predefined REGEX transformations to perform refactorings on any programming language or other types of text files.

## Build and run

1. Load project with IntelliJ
2. Press Build > Build Artifacts
3. Select Build on `refactoring-dev-tool:jar`
4. Goto command line
5. When in root directory of project, run newly built jar with command `java -jar out/artifacts/refactoring_dev_tool_jar/refactoring-dev-tool.jar [FILE_PATHS...]` - where [FILE PATHS...] are one or more absolute paths to files to perform refactoring on. Example: `java -jar out/artifacts/refactoring_dev_tool_jar/refactoring-dev-tool.jar a.java b.java c.java`

## Language & Transformations

In code you can define your own transformation rules. See class `transformations/TransformationRuleDefinition.java`. You can also change what file extension to expect by implementing a new `configuration/Configuration` and change the currently selected configuration used in the MainProgram.