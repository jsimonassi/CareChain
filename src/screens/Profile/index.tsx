import {Assets} from '../../assets/images';
import {AppButton} from '../../components/buttons/AppButton';
import {Input} from './components/Input';
import {
  Container,
  InputsContainer,
  ProfileContainer,
  ProfileImg,
  TitleText,
} from './styles';

export const Profile = () => {
  return (
    <Container>
      <TitleText>Profile Info</TitleText>
      <ProfileImg source={Assets.profile} />
      <ProfileContainer>
        <TitleText>Let us get to know you</TitleText>
        <InputsContainer>
          <Input name="Age" />
          <Input name="Weight" />
          <Input name="Height" />
          <Input name="Sex" />
        </InputsContainer>
      </ProfileContainer>
      <AppButton
        label="Continue"
        backgroundColor="primaryColor"
        textColor="white"
      />
    </Container>
  );
};
