    function progress()
    {
        document.studForm.buttonName.value = "progress/1";
        studForm.submit()
    }
    function addStudent()
    {
        document.studForm.buttonName.value = "addStudent";
        document.studForm.action="actionAdd";
        studForm.submit()
    }
    function modifyStudent()
    {
        document.studForm.buttonName.value = "modifyStudent";
        studForm.submit()
    }
    function deleteStudent()
    {
        document.studForm.buttonName.value = "deleteStudent";
        studForm.submit()
    }
