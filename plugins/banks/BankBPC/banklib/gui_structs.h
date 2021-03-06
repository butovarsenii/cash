#ifndef GUI_STRUCTS__H
#define GUI_STRUCTS__H

#pragma pack(push,1)
// ��������� ���������� ����������� ������
struct CurrencyParams
{
	// ��������� ���������.
	char CurAlpha[3];	// [in] ���������� ��� ������.
	unsigned char nDecPoint;	// [in] ������� ���������� ����� ��� ����������� ������.
};

// ��������� ���������� ������
struct ScreenParams
{
	long len;	// [in] ����� ������ ��������� � ������.
	// ��������� ���������.
	// ����� ���������� ������������� ������ ������ ���������,
	// � ����� ������� ���� ����� ����������� ������ � �����, �� ������ - �������������.
	// � �������-���������� ������ �������������� ��� ������ ������ ��������� ����,
	// �� ����������� � ����� ����� len. ���� len ������, ��� �������� � ����������,
	// �� ��� �������� ����� ������ ����������� ��������� ������.
	long screenID;	// [in] ������������� ������� �������.
	long maxInp;	// [in] ������������ ����� ��������� ������.
	long minInp;	// [in] ����������� ����� ��������� ������.
	unsigned long format;	// [in] ������ �������� ������:
	// ��� 0 ������� � ��������� ������ �����
	// ��� 0 ���������� � ��������� ����� �������
	// ����� �������, ���� �������� ���� �����, �� ������� ������ �����, ����� - �����.
	// ��� 1 ������� � ������ ���� �� ��������
	// ��� 1 ���������� � ������ ���� ��������
	// ��� 2 ������� � �������� ��� ������
	// ��� 2 ���������� � �������� ���������
	// ��� 3 ������� � ����������� ������ �������
	// ��� 3 ���������� � ����������� ������ �������
	// ��������� ���� ��������������� �� �������.
	// �������� ����� ���� �������:
	// 0x1 - ����� �������
	// 0x2 - �������� ���� ������ ������
	// 0x4 - ��� ����� ����������� (��� �������)
	// 0x8 - ����������� ������ �������
	// �������� ����� ��������������� �� <���>.
	// � ��������� �������� ��������� ������ ������ � ����������� ������, �������� �� ����,
	// � ��� ���� �������� ���� ������ ������ (��� 1 ����������).
	// ���������� ����� ��������� ������ ����� ���� ����� ����,
	// ��� ���������� � ��������� [min,max] ������������.
	// ������������ �����:  0 < length < min, max < length.

	// �������������� ��� ������ ��������: ����������� � �����������.
	// ����� ������ �������������� ����� 3 � ���� format.
	// ���������� ����� � ����������� ������ ������������ �������� �� ����������, ���������� ����� �����������.
	// � ����������� ������ ������ ������ ������ ������ ���������� �� ����������, ���������� ����� �������������.

	// ����, �������������� � ����������� ������:
	const char *pTitle;		// [in] ��������� �� zero-terminated ������,
	// ���������� ��������� ������. ����� ��������� �������� NULL.
	const char *pStr[10];	// [in] ������ ���������� �� zero-terminated ������.
	// ���������� ������ ������ ������������ ��������.
	// ��������� �� �������������� ������ ����� ����� �������� NULL.
	const char *pInitStr;	// [in] ��������� �� zero-terminated ������,
	// ���������� ��������� �������� ������ �����. ����� ��������� �������� NULL.
	const char *pButton0;	// [in] ��������� �� zero-terminated ������,
	// ���������� ����� �� ������ 0. ����� ��������� �������� NULL.
	const char *pButton1;	// [in] ��������� �� zero-terminated ������,
	// ���������� ����� �� ������ 1. ����� ��������� �������� NULL.

	// ����, �������������� �� ���� �������:
	CurrencyParams CurParam;	// [in] ��������� ����������� ������

	long eventKey;	// [out] ��� �����:
	// 0x20 - ������� ������ � ������ ������� <Enter>
	// ��������������� ��������� ������ ��������� � ������, ����������� pBuf
	// 0x21 - ���� ������ ������� <Esc> (����������  ����������, �������� ����)
	// 0x22 � ����� ������� �������� �����
	// 0x30 - 0x39 - �����������  ���� (������  ����  �������, ��������������� ������������� ������)
	// ��� ������������ ������ � 0x30 - 0xFF - ��� ������������ ������.
	char *pBuf;	// [in] ��������� �� ����� ��� zero-terminated ������, ��������� ��������.
	// ����� ���������� � ���������� �������. ����� ������ - �� ����� (maxInp + 1) ����.
	// ��������� ������ ������ ���� �� ����� maxInp ��������, ����� �� �������� ������ ������.
	// � ������ ������������ ����� ���������� ������ � ������ ����� ��� �������������.
	// �������� ������� ��������� ����� ����� ���� ��� ��� ����� ��������,
	// � ������� �������������� ���� ������, � ��� ��������� - ����� ��������� �������� NULL.
};

// ��������� ���������� ������ ������������ ����
struct ScreenParamsEx: public ScreenParams
{
	// ����, �������������� � ����������� ������:
	char *pExtStr;	// [in] ��������� �� zero-terminated ������-���������,
	// ���������� ��������� ������ � ��������� �������:
	// <T><����� 1>'\r'
	// <T><����� 2>'\r'
	// . . .
	// � ����������� ������ �� ���������� �������������.
	// <T> � � ����������� ������ �����������. ��� ������������ ������ ��� ������: ���������, ����� � �.�.
	// <�����> � �����, ��������� � ������������ ����� ������� �������� �������.
	// '\r' - ����������� ����� � ����� 0x0D.
	// ��� ���������� ����� ������� �� ����������� ������������� ������� �� ����������.
};

#pragma pack(pop)

// Is key pressed on keyboard
typedef int (* TRGUI_KeyIsPressed)( void );
// Get key from keyboard
typedef int (* TRGUI_KeyGet)( void );

// Show Screen
//typedef int (* TRGUI_ScreenShowEx)( int nDispTID, char * pStr[DSP_MAX_LINES] );
typedef int (* TRGUI_ScreenShow)( ScreenParams* pScreenParams );
// Show Entry text
typedef int (* TRGUI_ScreenEntry)( char * pStr, int nEntryWidth );
// Close Screen
typedef void (* TRGUI_ScreenClose)( void );

#endif // GUI__H
