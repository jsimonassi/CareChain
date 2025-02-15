import {Text} from 'react-native';
import {Container, SubContainer, SubTitleText} from './styles';
import {Device} from './components/Device';
import {AppButton} from '../../components/buttons/AppButton';

export const Scanning = () => {
  return (
    <Container>
      <SubContainer>
        <SubTitleText>Select your device:</SubTitleText>
        <Device description="AB:AB:00:4T:55:CC" name="Life Ultra GPS" />
        <Device description="AB:AB:00:4T:55:CC" name="GTX44" />
        <Device description="AB:AB:00:4T:55:CC" name="IDW30" />
      </SubContainer>
      <AppButton
        label="Search again"
        backgroundColor="primaryColor"
        textColor="white"
      />
    </Container>
  );
};
