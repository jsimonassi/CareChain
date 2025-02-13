import styled from 'styled-components/native';

export const StyledContainer = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.primaryColor};
  justify-content: center;
  align-items: center;
`;

export const StyledIconContainer = styled.View`
  flex: 3;
  justify-content: center;
  align-items: center;
`;

export const StyledButtonContainer = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
  width: 80%;
`;

export const StyledLogo = styled.Image`
  object-fit: contain;
  height: 20%;
  max-width: 250px;
`;

export const StyledMetamaskLogo = styled.Image`
  object-fit: contain;
  height: 30px;
  width: 30px;
  margin-left: 10px;
`;
