Set oFSO=CreateObject("Scripting.FileSystemObject")
	Set WshShell=CreateObject("WScript.Shell")
		strCurDir    = WshShell.CurrentDirectory
		For Each oFile In oFSO.GetFolder(strCurDir).Files
			If UCase(oFSO.GetExtensionName(oFile.Name)) = "BAT"  Then
				oFSO.DeleteFile strCurDir+"\"+oFile.Name,True
			End If
		Next
		strCurDirVal=Replace(strCurDir,"batFiles\localizationBatFiles","src\test\testSuiteFiles\localizationSuiteFiles")
		For Each oFile In oFSO.GetFolder(strCurDirVal).Files
		  If UCase(oFSO.GetExtensionName(oFile.Name)) = "XML" Then
			strFileNameVal=strCurDir+"\"+Split(oFile.Name,".")(0)+".bat"
			Set OutPutFile = oFSO.OpenTextFile(strFileNameVal ,8 , True)
				OutPutFile.WriteLine("cd "+""""+Replace(strCurDir,"\batFiles\localizationBatFiles","")+"""")
				OutPutFile.WriteLine("mvn test -Dsurefire.suiteXmlFiles="+""""+strCurDirVal+"\"+oFile.Name+"""")
			Set OutPutFile=Nothing
		  End if
		Next
	Set WshShell = Nothing
Set oFSO = Nothing