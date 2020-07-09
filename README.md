# **Displaying User Feedback**

**Project details:**

Spring boot based rest api for storing feedback. It provides features to add, query, delete and update the feedback. Attributes used are id, feedbackForAuthor, starsOverall, starsAuthor, feedbackOverall, bookName and extraComments.

Steps to run the project:

1. Import as a maven project
2. Update the maven project so that it downloads the dependencies
3. Run the project as a spring boot App
4. Please visit the swagger endpoint to view the endpoints:

[http://localhost:9091/swagger-ui.html](http://localhost:9091/swagger-ui.html)

List of Available Endpoints

| Endpoint | Method | Parameters | Usage |
| --- | --- | --- | --- |
| /feedback | POST | feedbackForAuthor(String); starsOverall(int); starsAuthor(int); feedbackOverall(String); bookName(String); extraComments(String); | Create a new feedback |
| /feedback/{id} | GET | Id(int) | Returns the feedback associated with the ID |
| /feedback | PUT | Id(int); feedbackForAuthor(String); starsOverall(int); starsAuthor(int); feedbackOverall(String); bookName(String); extraComments(String); | Update a Feedback |
| /feedback/{id} | DELETE | Id(int) | Delete the feedback associated with the id |
| /feedbacks | GET | - | Returns all feedback |
