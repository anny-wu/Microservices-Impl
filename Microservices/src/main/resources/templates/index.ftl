<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.0.js"
            integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<style>
    .line{
        margin:20px;
    }
</style>
<body>
    <div  class="cover-container d-flex h-100 p-3 flex-column align-items-center justify-content-center">
        <form>
            <div class="form-group row">
                <label id="labele" class="col-4 col-form-label"><strong>Select ID</strong></label>
                <div class="col-6">
                    <div class="form-outline">
                        <#if users??>
                            <select id="selectS" name="id" class="form-select">
                                <#list users as s>
                                    <#if s.id == selected>
                                        <option value=${s.id} selected>User ${s.id}</option>
                                    <#else>
                                        <option value=${s.id}>User ${s.id}</option>
                                    </#if>
                                </#list>
                            </select>
                        </#if>
                    </div>
                </div>
            </div>
            <div class="line">
                <div class="form-check form-check-inline">
                    <#if dbInfo??>
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="INFO" checked>
                    <#else>
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="INFO">
                    </#if>
                    <label class="form-check-label" for="inlineCheckbox1">INFO</label>
                </div>
                <div class="form-check form-check-inline">
                    <#if dbHobbies??>
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" name="HOBBIES" checked>
                    <#else>
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" name="HOBBIES">
                    </#if>
                    <label class="form-check-label" for="inlineCheckbox2">HOBBIES</label>
                </div>
                <div class="form-check form-check-inline">
                    <#if dbCourses??>
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox3" name="COURSES" checked>
                    <#else>
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox3" name="COURSES">
                    </#if>
                    <label class="form-check-label" for="inlineCheckbox3">COURSES</label>
                </div>
                <button class="btn btn-outline-primary" type="submit" formmethod="post" formaction="/">Search</button>
            </div>
            <div class="line">
                <#if dbInfo??>
                    <h3>User Info</h3>
                    <table class="table table-striped table-hover mx-auto">
                        <thead class="table-info">
                            <tr>
                                <#if info??>
                                    <th scope="col">ID</th>
                                    <th scope="col">USERNAME</th>
                                    <th scope="col">AGE</th>
                                </#if>
                            </tr>
                        </thead>
                        <tbody>
                            <#if info??>
                                <#list info as value>
                                    <td>${value}</td>
                                </#list>
                            </#if>
                        </tbody>
                    </table>
                </#if>
                <#if dbHobbies??>
                     <h3>Hobbies</h3>
                     <table class="table table-striped table-hover mx-auto">
                         <thead class="table-info">
                            <tr>
                                <th scope="col">Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list hobbies as name>
                                    <tr>
                                    <td>${name}</td>
                                    </tr>
                            </#list>
                        </tbody>
                    </table>
                </#if>
                <#if dbCourses??>
                     <h3>Courses</h3>
                    <table class="table table-striped table-hover mx-auto">
                        <thead class="table-info">
                        <tr>
                            <th scope="col">Name</th>
                        <tr>
                        </thead>
                        <tbody>
                        <#list courses as name>
                                <tr>
                                <td>${name}</td>
                                </tr>
                        </#list>
                        </tbody>
                    </table>
                 </#if>
            </div>
        </form>
    </div>
</body>
</html>

