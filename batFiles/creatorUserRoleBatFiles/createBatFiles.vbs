Set oFSO=CreateObject("Scripting.FileSystemObject")
	Set WshShell=CreateObject("WScript.Shell")
		strCurDir    = WshShell.CurrentDirectory
		For Each oFile In oFSO.GetFolder(strCurDir).Files
			If UCase(oFSO.GetExtensionName(oFile.Name)) = "BAT"  Then
				oFSO.DeleteFile strCurDir+"\"+oFile.Name,True
			End If
		Next
<<<<<<<< HEAD:PortalAutomation_v1.0/PortalAutomationScenarios/batFiles/creatorUserRoleBatFiles/createBatFiles.vbs
		strCurDirVal=Replace(strCurDir,"batFiles\creatorUserRoleBatFiles","src\test\testSuiteFiles\creatorUserRoleSuiteFiles")
========
		strCurDirVal=Replace(strCurDir,"batFiles\creatorRoleBatFiles","src\test\testSuiteFiles\creatorRoleSuiteFiles")
>>>>>>>> 17ea915f510d83a4b46606d6502bd4b9b46bd241:PortalAutomation_v1.0/PortalAutomationScenarios/batFiles/creatorRoleBatFiles/createBatFiles.vbs
		For Each oFile In oFSO.GetFolder(strCurDirVal).Files
		  If UCase(oFSO.GetExtensionName(oFile.Name)) = "XML" Then
			strFileNameVal=strCurDir+"\"+Split(oFile.Name,".")(0)+".bat"
			Set OutPutFile = oFSO.OpenTextFile(strFileNameVal ,8 , True)
<<<<<<<< HEAD:PortalAutomation_v1.0/PortalAutomationScenarios/batFiles/creatorUserRoleBatFiles/createBatFiles.vbs
				OutPutFile.WriteLine("cd "+""""+Replace(strCurDir,"\batFiles\creatorUserRoleBatFiles","")+"""")
========
				OutPutFile.WriteLine("cd "+""""+Replace(strCurDir,"\batFiles\creatorRoleBatFiles","")+"""")
>>>>>>>> 17ea915f510d83a4b46606d6502bd4b9b46bd241:PortalAutomation_v1.0/PortalAutomationScenarios/batFiles/creatorRoleBatFiles/createBatFiles.vbs
				OutPutFile.WriteLine("mvn test -Dsurefire.suiteXmlFiles="+""""+strCurDirVal+"\"+oFile.Name+"""")
			Set OutPutFile=Nothing
		  End if
		Next
	Set WshShell = Nothing
Set oFSO = Nothing