Set oFSO=CreateObject("Scripting.FileSystemObject")
	Set WshShell=CreateObject("WScript.Shell")
		strCurDir    = WshShell.CurrentDirectory
		For Each oFile In oFSO.GetFolder(strCurDir).Files
		  If UCase(oFSO.GetExtensionName(oFile.Name)) = "BAT" and InStr(1,oFile.Name,"usersRoleMyProfile_1",1) = 0 Then
			WshShell.Run strCurDir+"\"+oFile.Name
			WScript.Sleep 5*60*1000
		  End if
		Next
	Set WshShell = Nothing
Set oFSO = Nothing